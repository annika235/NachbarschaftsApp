import { Adresse } from './adresse';
import { Beitrag } from './beitrag';

export interface Nutzer {
  vorname: string;
  nachname: string;
  standort: Adresse;
  beitraege: Beitrag;
}

