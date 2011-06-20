package org.example

class User {
	String userName
	String facebookUID 

    static constraints = {
		 userName(blank: false)
    }
}
