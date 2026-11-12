import { Routes } from '@angular/router';
import {User} from './user/user';
import {Settings} from './user/settings/settings';


export const routes: Routes = [
  {path: 'nutzer', component: User},
  {path: 'nutzer/einstellungen', component: Settings}
];
