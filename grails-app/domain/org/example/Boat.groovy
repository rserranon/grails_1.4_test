package org.example

class Boat {
    String name
    String owner

    static constraints = {
        name(blank: false)
        owner(blank: false)
    }
}
