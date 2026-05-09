use std::cmp;
use std::fmt::{Display, Formatter, Result};

#[derive(Debug)]
pub struct Clock {
    hours: i32,
    minutes: i32,
}

fn add_minutes(old_minutes: i32, addition_minutes: i32) -> (i32, i32) {
    let num_hrs = addition_minutes / 60;
    let new_minutes = (old_minutes + addition_minutes) % 60;
    if new_minutes < 0 {
        (num_hrs - 1, new_minutes + 60)
    } else {
        (num_hrs, new_minutes)
    }
}

impl Clock {
    pub fn new(hours: i32, minutes: i32) -> Self {
        (Clock {
            hours: 0,
            minutes: 0,
        })
        .add_minutes(hours * 60)
        .add_minutes(minutes)
    }

    pub fn add_minutes(&self, minutes: i32) -> Self {
        let total_minutes = (self.hours * 60) + self.minutes + minutes;
        let new_hours = (total_minutes / 60) % 24;
        let new_hours = if new_hours < 0 {
            new_hours + 24
        } else {
            new_hours
        };
        let new_minutes = total_minutes % 60;
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
