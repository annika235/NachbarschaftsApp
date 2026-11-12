import {inject, Service, signal, WritableSignal} from '@angular/core';
import {NutzerClient} from './nutzer-client';
import {Nutzer} from '../model/nutzer';

@Service()
export class NutzerService {
  nutzerClient: NutzerClient = inject(NutzerClient);
  aktiverNutzer: WritableSignal<Nutzer> = signal({} as Nutzer);


  ladeNutzer() {
    const uuid = "26e18b46-7202-4795-9890-72ddda08de77";
    this.nutzerClient.zeigeNutzer(uuid).subscribe({
      next: (response: any) => {
        this.aktiverNutzer.set(response);
      }
    });
  }
  bearbeiteNutzer(geanderterNutzer: Nutzer){
    const uuid = "26e18b46-7202-4795-9890-72ddda08de77";
    this.nutzerClient.bearbeiteNutzer(uuid, geanderterNutzer).subscribe({
      next: (response: any)=> {
        this.aktiverNutzer.set(response);
      }

    })
  }
}
