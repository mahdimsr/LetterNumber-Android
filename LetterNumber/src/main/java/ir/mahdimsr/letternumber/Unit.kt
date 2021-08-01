package ir.mahdimsr.letternumber

import kotlin.math.pow

enum class Unit(val persianUnit: String,val basicValue : Double)
{
    NORMAL("",10.0.pow(2)),
    THOUSAND("هزار",10.0.pow(3)),
    MILLION("میلیون",10.0.pow(6)),
    BILLION("میلیارد",10.0.pow(9))
}