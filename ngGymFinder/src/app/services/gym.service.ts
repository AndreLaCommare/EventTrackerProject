import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Gym } from '../models/gym';

@Injectable({
  providedIn: 'root'
})
export class GymService {
  private baseUrl = 'http://localhost:8083/'; // adjust port to match server
  private url = this.baseUrl + 'api/gyms'; // change 'todos' to your API path

  constructor(private http : HttpClient) {}


  index(): Observable<Gym[]> {
    return this.http.get<Gym[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('GymService.index(): error retrieving Gyms: ' + err)
        );
      })
    );
  }


  create(gym: Gym): Observable<Gym>{

    return this.http.post<Gym>(this.url, gym).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('GymService.create(): error creating gym: ' + err)
        );
      })
    );
  }


  update (gym: Gym){

    return this.http.put<Gym>(this.url + "/" + gym.id, gym).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('GymService.update(): error updating gym: ' + err)
        );
      })
      );
  }

  destroy(gymId: number): Observable<void> {
    return this.http.delete<void>(this.url+"/"+gymId).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('GymService.destroy(): error deleting gym: ' + err)
        );
      })
      );

  }
}
