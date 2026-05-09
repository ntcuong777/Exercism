use std::cmp;
use std::fmt::{Display, Formatter, Result};

#[derive(Debug)]
pub struct Clock {
    hours: i32,
    minutes: i32,
}

impl Clock {
    fn normalize_time(&self) -> Self {
        let new_hours = (self.hours + self.minutes / 60) % 24;
        let new_hours = if new_hours < 0 {
            new_hours + 24
        } else {
            new_hours
        };
        let new_minutes = self.minutes % 60;
        let new_minutes = if new_minutes < 0 {
            new_minutes + 60
        } else {
            new_minutes
        };
        Clock {
            hours: new_hours,
            minutes: new_minutes,
        }
    }
    pub fn new(hours: i32, minutes: i32) -> Self {
        (Clock { hours, minutes }).normalize_time()
    }

    pub fn add_minutes(&self, minutes: i32) -> Self {
        (Clock {
            hours: self.hours,
            minutes: self.minutes + minutes,
        })
        .normalize_time()
    }
}

impl Display for Clock {
    fn fmt(&self, f: &mut Formatter<'_>) -> Result {
        write!(f, "{:02}:{:02}", self.hours, self.minutes)
    }
}

impl cmp::PartialEq for Clock {
    fn eq(&self, other: &Self) -> bool {
        self.hours == other.hours && self.minutes == other.minutes
    }
}
