// https://github.com/asadsahi/ng2fb-bootstrap/blob/master/src/app/shared/services/data.service.ts
import { Injectable } from '@angular/core';

import { ApiGatewayService } from './api-gateway.service';

@Injectable()
export class DataService {

    constructor(public http: ApiGatewayService) { }

    public get(url: string, params?: any): any {
        return this.http.get(url, undefined);
    }

    public post(url: string, data: any, params?: any): any {
        return this.http.post(url, data, params);
    }

    public put(url: string, data: any, params?: any): any {
      return this.http.put(url, data, params);
    }

    public delete(url: string, data: any, params?: any): any {
      return this.http.delete(url, data, params);
    }
}
