import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/Services/AuthService';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
//injection de dependance
constructor(private AS:AuthService, private router:Router){

}

  signin():void{

    this.AS.doGoogleLogin().then(()=>{
      this.router.navigate(['/member'])

    })

  }

}
