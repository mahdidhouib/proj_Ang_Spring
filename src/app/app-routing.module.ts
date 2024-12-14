import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MemberFormComponent } from './member-form/member-form.component';
import { MemberComponent } from './member/member.component';
import { DashbordComponent } from './dashbord/dashbord.component';
import { ToolsComponent } from './tools/tools.component';
import { EventsComponent } from './events/events.component';
import { ArticlesComponent } from './articles/articles.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {
    path : 'dashbord',
    pathMatch: 'full',
    component:DashbordComponent
  },
  {
    path : 'tools',
    pathMatch: 'full',
    component:ToolsComponent
  },
  {
    path : 'events',
    pathMatch: 'full',
    component:EventsComponent
  },
  {
    path : 'member',
    pathMatch: 'full',
    component:MemberComponent
  },
  {
    path : 'articles',
    pathMatch: 'full',
    component:ArticlesComponent
  },
  {
    path : 'create',
    pathMatch: 'full',
    component:MemberFormComponent
  },{
    path: '',
    pathMatch: 'full',
    component:LoginComponent
  },
  {
    path:':id/edit',
    pathMatch: 'full',
    component:MemberFormComponent
  },
  {
    path: '**',
    component:MemberComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
