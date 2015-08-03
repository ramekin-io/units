(ns io.ramekin.units
  (:require [clojure.string :refer [trim]]
            [me.raynes.conch :as sh]))

(defn- units
  ;; shell out unit conversion to units(1)
  [from-units to-units]
  (sh/let-programs [units "units"]
    (bigdec (trim (units (name from-units)
                         (name to-units)
                         "--terse")))
    ))

(defn convert
  "Convert units"
  ([from-unit to-unit]
   (units from-unit to-unit))
  ([quantity from-unit to-unit]
   (* (bigdec quantity)
      (units from-unit to-unit))))

