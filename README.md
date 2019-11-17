# khronos

[![Build Status](https://travis-ci.org/hotchemi/khronos.svg?branch=master)](https://travis-ci.org/hotchemi/khronos) [![Download](https://api.bintray.com/packages/hotchemi/maven/khronos/images/download.svg) ](https://bintray.com/hotchemi/maven/khronos/_latestVersion) [![License](https://img.shields.io/badge/license-APACHE2-green.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

An intuitive Date extensions in Kotlin.

## Usage

### Add durations to date

```kotlin
val today = Dates.today
val nextWeek = today + 1.week
val dayBeforeYesterday = today - 2.days

// shortcuts #1
val tomorrow = Dates.tomorrow
val yesterday = Dates.yesterday

// shortcuts #2
val yesterday = 1.days.ago
val fiveYearsSince = 5.years.since
```

### Initialize by specifying date components

```kotlin
val birthday = Dates.of(year = 1990, month = 1, day = 21)
val firstCommitDate = Dates.of(year = 2016, month = 2, day = 26, hour = 18, minute = 58, second = 31, millisecond = 777)
```

### Initialize by changing date components

```kotlin
val today = Dates.today
val christmas = today.with(month = 12, day = 25)
val thisSunday = today.with(weekday = 1)

// shortcuts
val newYearDay = today.beginningOfYear
val newYearsEve = today.endOfYear
```

### Check day of the week

```kotlin
Dates.today.isFriday() // false
```

### Format and parse

```kotlin
5.minutes.since.toString("yyyy-MM-dd HH:mm:SS")
//=> "2015-03-01 12:05:00"

"1987-06-02".toDate("yyyy-MM-dd")
//=> Dates.of(year = 1987, month = 6, day = 2)
```

### Compare dates

```kotlin
1.day.ago > 2.days.ago // true
1.day.ago in 2.days.ago..Dates.today // true
```

## Install

`${latest.version}` = [![Download](https://api.bintray.com/packages/hotchemi/maven/khronos/images/download.svg) ](https://bintray.com/hotchemi/maven/khronos/_latestVersion)

```groovy
dependencies {
  compile 'com.github.hotchemi:khronos:${latest.version}'
}
```

## Notice

- khronos is definitely inspired by [naoty/Timepiece(Swift)](https://github.com/naoty/Timepiece).

## Licence

```
Copyright 2016 Shintaro Katafuchi

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
