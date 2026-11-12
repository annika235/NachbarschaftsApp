import {inject, Service} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Nutzer} from '../model/nutzer';

@Service()
export class NutzerClient {
  http: HttpClient = inject(HttpClient);

  zeigeNutzer(uuid: string) {
    return this.http.get<Nutzer>("http://localhost:8081/nutzer/" + uuid);
  }

  speichereNutzer(uuid: string, nutzer: Nutzer){
    return this.http.put("http://localhost:8081/nutzer/"+ uuid, nutzer);
  }
}
