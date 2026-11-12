import {inject, Service, signal, WritableSignal} from '@angular/core';
import {NutzerClient} from './nutzer-client';
import {Nutzer} from '../model/nutzer';

@Service()
export class NutzerService {
  nutzerClient: NutzerClient = inject(NutzerClient);



  ladeNutzer() {
    const uuid = "26e18b46-7202-4795-9890-72ddda08de77";
    return this.nutzerClient.zeigeNutzer(uuid);
  }
  speichereNutzer(geanderterNutzer: Nutzer){
    const uuid = "26e18b46-7202-4795-9890-72ddda08de77";
    return this.nutzerClient.speichereNutzer(uuid, geanderterNutzer);
  }
}
