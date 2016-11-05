(ns clj-time-playground.core
  (:require [clj-time.core :as time]))

;; Dates and times in timezones

(def halloween-2016 (time/date-time 2016 10 31 18 0 0))
;; => #object[org.joda.time.DateTime 0x3136da76 "2016-10-31T18:00:00.000Z"]

(time/time-zone-for-id "US/Central")
;; => #object[org.joda.time.tz.CachedDateTimeZone 0x9a48d32 "America/Chicago"]

(time/time-zone-for-offset -6)
;; => #object[org.joda.time.tz.FixedDateTimeZone 0x29eb2cfb "-06:00"]

(def hal-central (time/from-time-zone halloween-2016 (time/time-zone-for-id "US/Central")))
;; => #object[org.joda.time.DateTime 0x70fd540b "2016-10-31T18:00:00.000-05:00"]

(def tz-london (time/time-zone-for-id "Europe/London"))
;; => #object[org.joda.time.tz.CachedDateTimeZone 0x4f101155 "Europe/London"]

(time/to-time-zone hal-central tz-london)
;; => #object[org.joda.time.DateTime 0x58daf761 "2016-10-31T23:00:00.000Z"]

;; Representing birthdays and holidays

;; December 25

(def christmas [12 25])

(time/date-time 2016 (get christmas 0) (get christmas 1))
;; => #object[org.joda.time.DateTime 0x3db3fe59 "2016-12-25T00:00:00.000Z"]

(def erics-birthday (time/local-date 1981 7 18))

(time/local-date (time/year (time/today)) (time/month erics-birthday) (time/day erics-birthday))
;; => #object[org.joda.time.LocalDate 0x62047c9b "2016-07-18"]
;; => 2016
;; => #object[org.joda.time.LocalDate 0x2c7c4a58 "2016-11-05"]

;; Periods of time

(time/hours 4)
;; => #object[org.joda.time.Hours 0x2c9086ee "PT4H"]

(time/days 3)
;; => #object[org.joda.time.Days 0x151fdec3 "P3D"]

(-> 3 time/days)
;; => #object[org.joda.time.Days 0x151fdec3 "P3D"]

(time/plus (time/now) (time/days 3))
;; => #object[org.joda.time.DateTime 0x59e5b69 "2016-11-08T17:38:25.768Z"]
;; => #object[org.joda.time.DateTime 0x4c3608b8 "2016-11-05T17:38:01.175Z"]

(-> 3 time/days time/ago)
;; => #object[org.joda.time.DateTime 0x7c8a6480 "2016-11-02T17:39:17.462Z"]

(-> 6 time/hours time/from-now)
;; => #object[org.joda.time.DateTime 0x101ca2cb "2016-11-05T23:39:42.111Z"]

(time/before? (time/now) (-> 3 time/years time/from-now))
;; => true

(time/after? ...)


(def now (time/now))
(= now now)
;; => true

(def d1 (time/date-time 2015 4 5))
(def d2 (time/plus (time/date-time 2014 4 5) (time/years 1)))
d1;; => #object[org.joda.time.DateTime 0x1bf6fa7f "2015-04-05T00:00:00.000Z"]
d2;; => #object[org.joda.time.DateTime 0x21559bcc "2015-04-05T00:00:00.000Z"]

(= d1 d2);; => true

(time/in-weeks (time/hours 72)) ;; => #object[org.joda.time.Hours 0x1f7446ad "PT72H"]
;; => 0
;; => 3
;; => 3
;; => 4320

