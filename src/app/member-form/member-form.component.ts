import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Member } from 'src/Model/Member';
import { MemberService } from 'src/Services/member.service';

@Component({
  selector: 'app-member-form',
  templateUrl: './member-form.component.html',
  styleUrls: ['./member-form.component.css']
})
export class MemberFormComponent implements OnInit{
  constructor(private MS: MemberService,private router:Router,private activatedRoute:ActivatedRoute){

  }
  
  form!:FormGroup;

  ngOnInit(){
    //1. recupere le rout actif de la route
    const idcourant = this.activatedRoute.snapshot.params['id'];
    console.log(idcourant);
    //2 if id exist et a une valeur =>je suis dans edit
    if(!!idcourant)
    {
      this.MS.getMemberByID(idcourant).subscribe((m)=>{
        this.form=new FormGroup({
          cin:new FormControl(m.cin,[Validators.required]),
          name:new FormControl(m.name,[Validators.required]),
          type:new FormControl(m.type,[Validators.required]),
          cv:new FormControl(m.cv,[])
        })

      })

    }
    else{this.initform();}
    //3. sinon je suis dans create

  }
 initform(){
  this.form=new FormGroup({
    cin:new FormControl(null,[Validators.required]),
    name:new FormControl(null,[Validators.required]),
    type:new FormControl(null,[Validators.required]),
    cv:new FormControl(null,[])
  })

}
sub():void{
  const idcourant = this.activatedRoute.snapshot.params['id'];
  console.log(idcourant);
  if(!!idcourant){
    //edit =>put
    const m : Member={...this.form.value,
      createddate:new Date()
    }
    this.MS.updateMember(m,idcourant).subscribe(()=>{
      this.router.navigate(['/member'])
    })

  }
  else{

  //recupere les donnes dans form
  console.log(this.form.value);
  //appeler la fonction de service
  const x={...this.form.value,createddate:new Date().toISOString()}
  this.MS.add(x).subscribe(()=>{
    this.router.navigate(['/member'])
  })
}

}
}
