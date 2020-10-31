import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'user', { responseType: 'text' });
  }

  getModeratorBoard(): Observable<any> {
    return this.http.get(API_URL + 'mod', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + 'admin', { responseType: 'text' });
  }

  getDashBoard(): Observable<any> {
    return this.http.get(API_URL + 'dashboard', { responseType: 'json' });
  }

  postDashBoard(rows): Observable<any> {
    //alert("insidr post dashboard");
    return this.http.post(API_URL + 'dashboard',rows,httpOptions);
  }

  getForceFactors(): Observable<any> {
    return this.http.get(API_URL + 'nforcefactor', { responseType: 'json' });
  }

  postForceFactors(rows): Observable<any> {
    //alert("insidr post dashboard");
    return this.http.post(API_URL + 'nforcefactor',rows,httpOptions);
  }

  getCategory(): Observable<any> {
    return this.http.get(API_URL + 'categoryhierarchy', { responseType: 'json' });
  }


  postCategory(rows): Observable<any> {
    //alert("insidr post dashboard");
    return this.http.post(API_URL + 'categoryhierarchy',rows,httpOptions);
  }

}
