package com.example.xmlusingretrofit

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable


@Root(name = "rss", strict = false)
class Feed constructor(

    @field:ElementList(inline = true, name = "channel")
    var entrys: List<Channel>? = null

) : Serializable {

}