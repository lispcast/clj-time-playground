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














