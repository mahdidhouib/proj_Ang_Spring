import { Component, OnInit } from '@angular/core';
import { stringToKeyValue } from '@angular/flex-layout/extended/style/style-transforms';
import { MatDialog } from '@angular/material/dialog';
import { Member } from 'src/Model/Member';
import { MemberService } from 'src/Services/member.service';
import { ConfirmComponent } from '../confirm/confirm.component';

@Component({
  selector: 'app-member',
  templateUrl: './member.component.html',
  styleUrls: ['./member.component.css']
})
export class MemberComponent implements OnInit{
  constructor (private MS : MemberService,private dialog :MatDialog){
    //permet d'utiliser le service dans les composant ou dans les autres services se fait en creant une instance privé du service dans le constructeur du composant (ou du service) 
  }
  dataSource :Member[]=[];
  displayedColumns: string[] = ['1', '2', 'name', 'type','date','edit','delete'];
//ngoninit tetruna kbal l constructeur
  ngOnInit():void{
    //appeler la fct du service getalmembers
    //atendre resultat
    //une fois on recoit le res >laffecter dans data sourec
    this.MS.getAllMembers().subscribe((response)=>{
    // action post resultat
    this.dataSource=response
  })}
  delete(id:string):void{

    //1.lancer la boite(confirmcomponent)
    const dialogRef = this.dialog.open(ConfirmComponent);


    //2 attendere le resu de l'user
    dialogRef.afterClosed().subscribe((response)=>{
      if(response==true){
        this.MS.deleteMember(id).subscribe(()=>{

          //action apres efface
            this.MS.getAllMembers().subscribe((response)=>{
              //avtion posr resultat
              this.dataSource=response
          
            })
            //
           })
        
      }
    })


    //3.si l'util a fait le click sur confirm


}
}
  

