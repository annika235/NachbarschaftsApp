// import { Adresse } from './adresse';
// import { Beitrag } from './beitrag';

export interface Nutzer {
  vorname: string;
  nachname: string;
  // standort: Adresse | null = null;
  // beitraege: Beitrag[] = [];
}

export const initialData: Nutzer= {
  vorname: 'Max',
  nachname: 'Mustermann'
}
