import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Evt } from 'src/Model/Evt';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  constructor(private httpClient:HttpClient) { }
  getAllEvt():Observable<Evt[]>{
    return this.httpClient.get<Evt[]>('http://localhost:3000/evt')
  }
  addEvent(x:Evt):Observable<Evt> {
    return this.httpClient.post<Evt>('http://localhost:3000/evt',x)


  }
  getEventById(id:string):Observable<Evt>
  {
    return this.httpClient.get<Evt>(`http://localhost:3000/evt/${id}`);
  }
  update(event:Evt , id:string):Observable<void>{
    return this.httpClient.put<void>(`http://localhost:3000/evt/${id}`,event);

  }
}
