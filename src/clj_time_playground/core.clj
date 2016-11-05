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
