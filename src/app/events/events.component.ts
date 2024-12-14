import { Component, OnInit } from '@angular/core';
import { Evt } from 'src/Model/Evt';
import { EventService } from 'src/Services/evt-service.service';
import { ModalComponent } from '../modal/modal.component';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { DialogRef } from '@angular/cdk/dialog';
@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {
  dataSource: Evt[] = [];
  constructor(private ES: EventService, private dialog: MatDialog) { }
  ngOnInit(): void {
    this.ES.getAllEvt().subscribe((Response) => {
      this.dataSource = Response

    })
  }
  displayedColumns: string[] = ['id', 'title', 'dateDebut', 'dateFin', 'lieu','edit','delete'];

  open(): void {
    const dialogRef = this.dialog.open(ModalComponent, {


    });
    //recuperer les donnees du modal
    dialogRef.afterClosed().subscribe((data) => {
      if (data==null ){
        return;
      }
      this.ES.addEvent(data).subscribe(() => {
        this.ES.getAllEvt().subscribe((data)=>{
          this.dataSource=data;
        })


      })
    })
  }
  open1(id:string):void{
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    dialogConfig.data = {id };

    const dialogRef=this.dialog.open(ModalComponent, dialogConfig);
    dialogRef.afterClosed().subscribe((data)=>{
      if(data){
        this.ES.update(data,id).subscribe(()=>{
          {
            //getAll
            this.ES.getAllEvt().subscribe((data)=>{
              this.dataSource=data;
            })
          }
        })
      }
    })
  }
}
