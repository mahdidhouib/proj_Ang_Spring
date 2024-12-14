import { Component, OnInit } from '@angular/core';
import { EventService } from 'src/Services/evt-service.service';
import { MemberService } from 'src/Services/member.service';
import { ChartDataset, ChartOptions } from 'chart.js';

@Component({
  selector: 'app-dashbord',
  templateUrl: './dashbord.component.html',
  styleUrls: ['./dashbord.component.css']
})
export class DashbordComponent {

  NB_members:number=0;
  NB_Events:number=0;
  NB_Tools:number=0;
  NB_Articles:number=0;
  nb_stdents :number=0;
  nb_teacher :number=0;
  chartData: ChartDataset[] = [
    {
      // ⤵️ Add these
      label: '$ in millions',
      data: [  ]
    }
  ];

  constructor(private MS:MemberService , private Eventservice : EventService){
    this.MS.getAllMembers().subscribe((data)=>{
      this.NB_members=data.length
      for(let i=0;i<this.NB_members;i++){
        if(data[i].type=="student")
          this.nb_stdents++;
        else this.nb_teacher++;
      }
      this.chartData=[
        {
          // ⤵️ Add these
          label: '$ in millions',
          data: [ this.nb_teacher , this.nb_stdents ]
        }
      ];

      console.log('aaaaaaaaa',this.nb_stdents);
      console.log(this.nb_teacher);

    })
  }


  chartLabels: string[] = ['nb_teacher', 'nb_students' ];
  chartOptions: ChartOptions = {};

}
