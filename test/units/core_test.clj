(ns units.core-test
  (:require [clojure.test :refer :all]
            [units.core :refer :all]))

(deftest test-convert
  (testing "Big Decimal always returned"
    (is (=
         (convert 1.5 :years :weeks)
         78.2661855M))

    (is (= (convert :years :weeks) 52.177457M))
    (is (= (convert 0 :years :weeks) 0M))
        )

  (testing "Volume"
    (are [x y] (= x y)
         (convert 50 "liters" "quarts") 52.83441M
         (convert 50 :liters  :quarts ) 52.83441M
         (convert 1  "liter"  "quart" ) 1.0566882M
         (convert 1  :liter   :quart  ) 1.0566882M
         )

    (are [x y] (= x y)
         (convert :liter  :liter ) 1M
         (convert :liter  :quart ) 1.0566882M
         (convert :liters :quarts) 1.0566882M
         (convert :quarts :liter ) 0.94635295M
         )
    )

  (testing "Mass"
    (are [x y] (= x y)
         (convert 50 "grams" "pounds") 0.11023113M
         (convert 50 :grams  :dram   ) 28.21916950M
         (convert 1  "pound" "carat" ) 2267.9619M
         )

    (are [x y] (= x y)
         (convert :dram   :dram      ) 1M
         (convert :gram   :kilogram  ) 0.001M
         (convert :μg     :g         ) 0.000001M
         )
    )

  (testing "Distance"
    (are [x y] (= x y)
         (convert 25 :mi      :km     ) 40.2336M
         (convert  2 :furlong :league ) 0.083333334M
         (convert 10 :mile    :nmi    ) 8.6897624M
         (convert 10 :km      :clicks ) 10M
         )

    (are [x y] (= x y)
         (convert :mi      :km     ) 1.609344M
         (convert :furlong :league ) 0.041666667M
         (convert :mile    :nmi    ) 0.86897624M
         (convert :km      :clicks ) 1M
         )
    )

  (testing "Distance"
    (are [x y] (= x y)
         (convert 300 :hours      :seconds) 1080000M
         (convert 1.5 :years      :weeks  ) 78.2661855M
         (convert   1 :millennium :days   ) 365242.2M
         )

    (are [x y] (= x y)
         (convert :hours      :seconds) 3600M
         (convert :seconds    :year   ) 3.1688765E-8M
         (convert :millennium :days   ) 365242.2M
         )
    )

  (testing "Speed"
    (are [x y] (= x y)
         (convert 50 "m/s" "furlongs per fortnight") 300644.24M
         )
    (are [x y] (= x y)
         (convert :mph  :kph  ) 1.609344M
         (convert :c    "m/s" ) 2.9979246E8M
         )
    )
  (testing "Speed"
    (are [x y] (= x y)
         (convert "tempF(45)" :tempC ) 7.2222222M
         (convert "tempF(45)" :tempK ) 280.37222M
         )
    )
  )

