import {Koordinaten} from './koordinaten';

export interface Adresse{
  strasse: string;
  hausnummer: string;
  plz: string;
  ort: string;
  koordinaten: Koordinaten;
}
