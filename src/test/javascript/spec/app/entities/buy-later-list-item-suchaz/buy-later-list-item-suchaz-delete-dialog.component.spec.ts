/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { SuchazapisTestModule } from '../../../test.module';
import { BuyLaterListItemSuchazDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/buy-later-list-item-suchaz/buy-later-list-item-suchaz-delete-dialog.component';
import { BuyLaterListItemSuchazService } from '../../../../../../main/webapp/app/entities/buy-later-list-item-suchaz/buy-later-list-item-suchaz.service';

describe('Component Tests', () => {

    describe('BuyLaterListItemSuchaz Management Delete Component', () => {
        let comp: BuyLaterListItemSuchazDeleteDialogComponent;
        let fixture: ComponentFixture<BuyLaterListItemSuchazDeleteDialogComponent>;
        let service: BuyLaterListItemSuchazService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [SuchazapisTestModule],
                declarations: [BuyLaterListItemSuchazDeleteDialogComponent],
                providers: [
                    BuyLaterListItemSuchazService
                ]
            })
            .overrideTemplate(BuyLaterListItemSuchazDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(BuyLaterListItemSuchazDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BuyLaterListItemSuchazService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        spyOn(service, 'delete').and.returnValue(Observable.of({}));

                        // WHEN
                        comp.confirmDelete(123);
                        tick();

                        // THEN
                        expect(service.delete).toHaveBeenCalledWith(123);
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
