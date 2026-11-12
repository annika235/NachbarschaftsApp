import {AfterViewInit, Component, effect, inject, OnInit, signal, untracked} from '@angular/core';
import {NutzerService} from '../../../services/nutzer-service';
import {JsonPipe} from '@angular/common';
import {initialData, Nutzer} from '../../../model/nutzer';
import {form, FormField, required} from '@angular/forms/signals';

@Component({
  imports: [
    JsonPipe,
    FormField
  ],
  selector: 'app-settings',
  styleUrl: './settings.css',
  templateUrl: './settings.html',
})
export class Settings implements OnInit{
  nutzerService: NutzerService = inject(NutzerService);
  nutzer = signal<Nutzer>(initialData)

  nutzerForm = form(this.nutzer, (path) => {
    required(path.vorname, { message: 'Name ist erforderlich' });
    required(path.nachname, { message: 'Name ist erforderlich' });
  });

  constructor() {
    effect(() => {
      // Wenn sich dieses Signal ändert dann rufe
      // ich diese funktion auf
       this.nutzerService.aktiverNutzer();

       untracked(() => {
         // und durchlaufe diesen code
         this.nutzerForm().reset(this.nutzerService.aktiverNutzer());
       })
    })
  }


  async ngOnInit() {
    this.nutzerService.ladeNutzer();
  }

  // wenn ich merke dass sich nutzerService.aktiverNutzer ändert, dann tu ich was



  protected testBla() {
    this.nutzerService.bearbeiteNutzer(this.nutzer());
  }
}
