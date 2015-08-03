# Units

A clojure library for mathing some units together.

```clojure
(convert 50 :millennium :days   ) # => 365242.2M
(convert    :km         :clicks ) # => 1M
```

This library outsorces it's mathing to the awesome gnu [`units(1)`](http://www.gnu.org/software/units/) program.

## Install

Depends on `units(1)`

```
sudo apt-get install units
```

Then add this to your `project.clj`:

[![Clojars Project](http://clojars.org/io.ramekin/units/latest-version.svg)](http://clojars.org/io.ramekin/units)


## Usage

Anything you can do with `units <first> <second> --terse` is fair game.

```clojure
(ns my.project
  (:require [io.ramekin.units :refer [convert]]))

;; Note -- appending "M" to a number is clojure's way of 
;;   denoting type 'BigDecimal'

;; Volume
(convert 50 :liters :quarts) # => 52.8344100M
(convert 1  :liters :quarts) # => 1.0566882M
(convert    :liters :quarts) # => 1.0566882M

;; Mass
(convert 50 :grams :pounds) # => 0.1102311300M
(convert 1  :grams :dram  ) # => 0.56438339M
(convert    :pound :carat ) # => 2267.9619M

;; Distance
(convert 25 :mi      :km     ) # => 40.233600M
(convert    :furlong :league ) # => 0.041666667M
(convert    :mile    :nmi    ) # => 0.86897624M
(convert    :km      :clicks ) # => 1M

;; Time
(convert :hour       :seconds) # => 3600M
(convert :seconds    :year   ) # => 3.1688765E-8M
(convert :millennium :days   ) # => 365242.2M

;; Speed
(convert 50 "m/s" "furlongs per fortnight") # => 300644.2400M
(convert    :mph  :kph                    ) # => 1.609344M
(convert    :c    "meters per second"     ) # => 2.9979246E+8M

;; Temp
(convert "tempC(0)" :tempF ) # => 32M
(convert "tempC(0)" :tempK ) # => 273.15M
```

## License

Copyright © 2015 Will O'Brien

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
