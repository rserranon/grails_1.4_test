package org.example



import org.junit.*
import grails.test.mixin.*


@TestFor(UserController)
@Mock(User)
class UserControllerTests {


    @Test
    void testIndex() {
        controller.index()
        assert "/user/list" == response.redirectedUrl
    }

    @Test
    void testList() {

        def model = controller.list()

        assert model.userInstanceList.size() == 0
        assert model.userInstanceTotal == 0

    }

    @Test
    void testCreate() {
       def model = controller.create()

       assert model.userInstance != null


    }

    @Test
    void testSave() {
        controller.save()

        assert model.userInstance != null
        assert view == '/user/create'

        // TODO: Populate valid properties

        controller.save()

        assert response.redirectedUrl == '/user/show/1'
        assert controller.flash.message != null
        assert User.count() == 1
    }


    @Test
    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/user/list'


        def user = new User()

        // TODO: populate domain properties

        assert user.save() != null

        params.id = user.id

        def model = controller.show()

        assert model.userInstance == user
    }

    @Test
    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/user/list'


        def user = new User()

        // TODO: populate valid domain properties

        assert user.save() != null

        params.id = user.id

        def model = controller.edit()

        assert model.userInstance == user
    }

    @Test
    void testUpdate() {

        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/user/list'

        response.reset()


        def user = new User()

        // TODO: populate valid domain properties

        assert user.save() != null

        // test invalid parameters in update
        params.id = user.id

        controller.update()

        assert view == "/user/edit"
        assert model.userInstance != null

        user.clearErrors()

        // TODO: populate valid domain form parameter
        controller.update()

        assert response.redirectedUrl == "/user/show/$user.id"
        assert flash.message != null
    }

    @Test
    void testDelete() {
        controller.delete()

        assert flash.message != null
        assert response.redirectedUrl == '/user/list'

        response.reset()

        def user = new User()

        // TODO: populate valid domain properties
        assert user.save() != null
        assert User.count() == 1

        params.id = user.id

        controller.delete()

        assert User.count() == 0
        assert User.get(user.id) == null
        assert response.redirectedUrl == '/user/list'


    }


}