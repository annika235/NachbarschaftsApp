import {Component, inject, OnInit, signal} from '@angular/core';
import {NutzerService} from '../../../services/nutzer-service';
import {Nutzer} from '../../../model/nutzer';
import {form, FormField, required, submit} from '@angular/forms/signals';
import {firstValueFrom} from 'rxjs';

@Component({
  imports: [
    FormField
  ],
  selector: 'app-settings',
  styleUrl: './settings.css',
  templateUrl: './settings.html',
})
export class Settings implements OnInit {
  nutzerService: NutzerService = inject(NutzerService);
  nutzer = signal<Nutzer>({vorname: '', nachname: '', standort: {strasse: '', hausnummer:'', plz:'', ort:'', koordinaten:{laengengrad: null, breitengrad: null}}, beitraege: [] });

  nutzerForm = form(this.nutzer, (path) => {
    required(path.vorname, {message: 'Vorname ist erforderlich'});
    required(path.nachname, {message: 'Nachname ist erforderlich'});
  });

  ngOnInit() {
    this.nutzerService.ladeNutzer().subscribe(nutzer => this.nutzer.set(nutzer));
  }

  async speichern(){
    await submit(this.nutzerForm, async () => {await firstValueFrom(this.nutzerService.speichereNutzer(this.nutzer()))});
  }
}


