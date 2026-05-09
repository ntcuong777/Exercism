use std::cmp;
use std::fmt::{Display, Formatter, Result};

#[derive(Debug)]
pub struct Clock {
    hours: i32,
    minutes: i32,
}

impl Clock {
    pub fn new(hours: i32, minutes: i32) -> Self {
        Clock { hours, minutes }
    }

    pub fn add_minutes(&self, minutes: i32) -> Self {
        let new_minutes = self.minutes + minutes;
        let new_hours = (self.hours + new_minutes / 60) % 24;
        let new_minutes = new_minutes % 60;
        Clock {
            hours: new_hours,
            minutes: new_minutes,
        }
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
