import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';
import { AuthService } from 'src/Services/AuthService';

@Component({
  selector: 'app-template',
  templateUrl: './template.component.html',
  styleUrls: ['./template.component.css']
})
export class TemplateComponent {

  constructor(private AS:AuthService, private router:Router){

  }
  
    signout():void{
  
      this.AS.doLogout().then(()=>{
        this.router.navigate([''])
  
      })
  
    }

}
