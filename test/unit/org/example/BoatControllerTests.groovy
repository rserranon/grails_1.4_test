package org.example



import org.junit.*
import grails.test.mixin.*


@TestFor(BoatController)
@Mock(Boat)
class BoatControllerTests {


    @Test
    void testIndex() {
        controller.index()
        assert "/boat/list" == response.redirectedUrl
    }

    @Test
    void testList() {

        def model = controller.list()

        assert model.boatInstanceList.size() == 0
        assert model.boatInstanceTotal == 0

    }

    @Test
    void testCreate() {
       def model = controller.create()

       assert model.boatInstance != null


    }

    @Test
    void testSave() {
        controller.save()

        assert model.boatInstance != null
        assert view == '/boat/create'

        // TODO: Populate valid properties

        controller.save()

        assert response.redirectedUrl == '/boat/show/1'
        assert controller.flash.message != null
        assert Boat.count() == 1
    }


    @Test
    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/boat/list'


        def boat = new Boat()

        // TODO: populate domain properties

        assert boat.save() != null

        params.id = boat.id

        def model = controller.show()

        assert model.boatInstance == boat
    }

    @Test
    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/boat/list'


        def boat = new Boat()

        // TODO: populate valid domain properties

        assert boat.save() != null

        params.id = boat.id

        def model = controller.edit()

        assert model.boatInstance == boat
    }

    @Test
    void testUpdate() {

        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/boat/list'

        response.reset()


        def boat = new Boat()

        // TODO: populate valid domain properties

        assert boat.save() != null

        // test invalid parameters in update
        params.id = boat.id

        controller.update()

        assert view == "/boat/edit"
        assert model.boatInstance != null

        boat.clearErrors()

        // TODO: populate valid domain form parameter
        controller.update()

        assert response.redirectedUrl == "/boat/show/$boat.id"
        assert flash.message != null
    }

    @Test
    void testDelete() {
        controller.delete()

        assert flash.message != null
        assert response.redirectedUrl == '/boat/list'

        response.reset()

        def boat = new Boat()

        // TODO: populate valid domain properties
        assert boat.save() != null
        assert Boat.count() == 1

        params.id = boat.id

        controller.delete()

        assert Boat.count() == 0
        assert Boat.get(boat.id) == null
        assert response.redirectedUrl == '/boat/list'


    }


}