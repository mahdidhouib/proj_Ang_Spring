import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Member } from 'src/Model/Member';

@Injectable({
  providedIn: 'root'
})
export class MemberService {
  //fo,nctions qui representent des crud sur member

  constructor(private http:HttpClient) { }

  getAllMembers():Observable<Member[]>
  {
    return this.http.get<Member[]>('http://localhost:3000/members');
  }
  add(x:Member):Observable<void>
  {
    return this.http.post<void>('http://localhost:3000/members',x);
  }

  deleteMember(id:string):Observable<void>
  {
    return this.http.delete<void>(`http://localhost:3000/members/${id}`)

    }
  getMemberByID(id:string):Observable<Member>
  {
    return this.http.get<Member>(`http://localhost:3000/members/${id}`);
  }
  updateMember(m:Member,idcourant:string):Observable<void>{
    return this.http.put<void>(`http://localhost:3000/members/${idcourant}`,m);
  }
 
}
