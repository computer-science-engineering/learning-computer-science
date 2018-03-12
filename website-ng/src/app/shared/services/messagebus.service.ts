/* http://www.processinginfinity.com/weblog/2016/08/18/MessageBus-Pattern-in-Angular2-TypeScript */
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';

interface IMessage {
    channel: string;
    data: any;
}

@Injectable()
export class MessageBusService {
    private readonly message$: Subject<IMessage>;

    constructor() {
        this.message$ = new Subject<IMessage>();
    }

    publish<T>(message: T): void {
        const channel = (message.constructor as any).name;
        this.message$.next({ channel: channel, data: message });
    }

    of<T>(messageType: { new (...args: any[]): T }): Observable<T> {
        const channel = (messageType as any).name;
        return this.message$.filter(m => m.channel === channel).map(m => m.data);
    }
}
