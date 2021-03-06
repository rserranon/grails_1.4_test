package org.example

import grails.converters.JSON
class FacebookTagLib {
  def facebookGraphService

    def fbInfo = { attrs ->
        if (session.facebook) {
          def myInfo = JSON.parse (facebookGraphService.getFacebookProfile().toString() )

          out << "<br/>id" << myInfo.id
          out << "<br/>first_name:" << myInfo.first_name
          out << "<br/>Last Name:" << myInfo.last_name
          out << "<br/>Gender:" << myInfo.gender
          out << "<br/>Timezone:" << myInfo.timezone
          out << "<br/>Home Town:" << myInfo.hometown
          out << "<br/>Link:" << myInfo.link
          out << "<br/>Photo:" << "<img src='${facebookGraphService.getProfilePhotoSrc(myInfo.id);}'/>"

        } else {
          out << "Not logged in to Facebook"
        }
    }

	def fbFriends = { attrs ->
        if (session.facebook) {
          def myFriends = JSON.parse (facebookGraphService.getFriends().toString() )
		  out << "<br/> Amigos: <br/>"		
		  myFriends.data.each { 
			out << "<img src='${facebookGraphService.getProfilePhotoSrc(it.id);}'/>"
		  }

        } else {
          out << "Not logged in to Facebook"
        }
    }

	def fbPublishWall = { attrs ->
        if (session.facebook) {
			
          facebookGraphService.publishWall(attrs.mensaje)

          out <<  "Se envio mensaje: ${attrs.mensaje}"

        } else {
          out << "Not logged in to Facebook"
        }
    }

	def fbLogOut = { attrs ->
        if (session.facebook) {
			
          session.facebook = [:] // we remove the session data

          out <<  "Logged Out"

        } else {
          out << "Already  Logged Out"
        }
    }

}