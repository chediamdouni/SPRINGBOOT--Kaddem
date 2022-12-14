import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Etudiant } from '../models/etudiant';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class EtudiantService {

  uri: string = environment.uri + 'Etudiant'

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(
    private http: HttpClient
  ) { }

  errorHandler(error: any) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
 }

  // Etudiant CRUD //
  addEtudiant(Etudiant: Etudiant){
    return this.http.post<Etudiant>(this.uri + '/add/', JSON.stringify(Etudiant), this.httpOptions)
      .pipe(catchError(this.errorHandler))
  }

  getAllEtudiant(){
    return this.http.get<Etudiant[]>(this.uri + '/getAll/')
    .pipe(catchError(this.errorHandler))
  }

  getEtudiantById(EtudiantId: number){
    return this.http.get<Etudiant>(this.uri + '/getById/' + EtudiantId)
    .pipe(catchError(this.errorHandler))
  }

  updateEtudiant(
    EtudiantId: number,
    Etudiant: Etudiant){
      return this.http.put<Etudiant>(this.uri + '/update/', JSON.stringify(Etudiant), this.httpOptions)
    .pipe(
      catchError(this.errorHandler)
    )
  }

  deleteEtudiant(EtudiantId: number){
    return this.http.delete<Etudiant>(this.uri + '/delete/' + EtudiantId, this.httpOptions)
    .pipe(
      catchError(this.errorHandler)
    )
  }
}
