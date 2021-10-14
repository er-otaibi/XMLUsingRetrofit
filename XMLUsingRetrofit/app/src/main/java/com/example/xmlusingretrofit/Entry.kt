package com.example.xmlusingretrofit

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable


@Root(name = "channel", strict = false)
class Channel @JvmOverloads constructor(

    @field:Element(name = "title")
    @param:Element(name = "title")
    var content1: String? = null,

    @field:Element(required = false, name = "language")
    @param:Element(name = "language")
    var content2: String? = null,

    @field:Element(required = false, name = "generator")
    @param:Element(name = "generator")
    var content3: String? = null,
) : Serializable {

}