import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import * as jwt_decode from 'jwt-decode';

@Injectable({ providedIn: 'root' })
export class AuthLoginGuard implements CanActivate {

    constructor(private _router: Router) { }

    canActivate(): boolean {
        const session = JSON.parse(localStorage.getItem('session'));
        if (session !== null) {
            const token = session.token;
            const jwtDecode = require('jwt-decode');
            const isBeAbleTo = new Date() <= new Date(jwtDecode(token).exp * 1000);
            
            if (isBeAbleTo) {
                this._router.navigate(['pages', 'dashboard']);
                return false;
            } else {
                localStorage.removeItem('session');
                this._router.navigate(['pages', 'login?invalid-session']);
                return true;
            }
        } else {
            return true;
        }

    }

}
