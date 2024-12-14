import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

import { initializeApp } from 'firebase/app';
import { Evt } from 'src/Model/Evt';
import { EventService } from 'src/Services/evt-service.service';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent {
  //forcage de type
  id!:string;

  constructor(public dialogRef: MatDialogRef<ModalComponent>, @Inject(MAT_DIALOG_DATA) data:any,private ES:EventService) {
    if(!!this.id){
      this.ES.getEventById(this.id).subscribe((evt)=>{
        console.log(evt);
        this.initForm1(evt);
        console.log('h',evt.title)
      })
    }else{
      this.initForm();
    }

   }

  form!:FormGroup;


  initForm(): void{
    this.form=new FormGroup({
      title:new FormControl(null),
      dateDebut:new FormControl(null),
      dateFin:new FormControl(null),
      lieu:new FormControl(null,)
    })


  }

  initForm1(event: Evt): void{
    this.form=new FormGroup({
      title:new FormControl(event.title),
      dateDebut:new FormControl(event.dateDebut),
      dateFin:new FormControl(event.dateFin),
      lieu:new FormControl(event.lieu)
    })


  }




  save() {
    this.dialogRef.close(this.form.value);
}

close() {
    this.dialogRef.close();
}
  

}
