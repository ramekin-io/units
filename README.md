# clj-units

A clojure library for mathing some units together.

This library outsorces it's mathing to the awesome gnu [`units(1)`](http://www.gnu.org/software/units/) binary.

## Install

```
sudo apt-get install units
```


## Usage

Anything you can do with `units <first> <second> --terse` is fair game.


```clojure
(ns my.project
  (:require [io.ramekin.units :refer [convert]]))

;; Volume
(convert 50 :liters :quarts) # => 52.83441
(convert 1  :liters :quarts) # => 1.0566882
(convert    :liters :quarts) # => 1.0566882

;; Mass
(convert 50 :grams :pounds) # => 0.11023113
(convert 1  :grams :dram  ) # => 0.56438339
(convert    :pound :carat ) # => 2267.9619

;; Distance
(convert 25 :mi      :km            ) # => 40.2336
(convert    :furlong :league        ) # => 0.041666667
(convert    :mile    "nautical mile") # => 0.86897624
(convert    :km       clicks        ) # => 1

;; Time
(convert :hour       :seconds) # => 3600
(convert :seconds    :year   ) # => 3.1688765E-8
(convert :millennium :days   ) # => 365242.2

;; Speed
(convert 50 "m/s" "furlongs per fortnight") # => 300644.24
(convert    :mi/h :km/h                   ) # => 1.609344
(convert    :c    :m/s                    ) # => 2.9979246E8

;; Temp
(convert "tempF(45)" :tempC ) # => 7.2222222
(convert "tempF(45)" :tempK ) # => 280.37222
```

## License

Copyright © 2015 Will O'Brien

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
