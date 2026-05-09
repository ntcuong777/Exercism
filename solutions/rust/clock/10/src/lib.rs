use std::cmp;
use std::fmt::{Display, Formatter, Result};

#[derive(Debug)]
pub struct Clock {
    minutes: i32,
}

impl Clock {
    pub fn new(hours: i32, minutes: i32) -> Self {
        let norm_hrs = if hours < 0 {
            (hours % 24) + 24
        } else {
            hours % 24
        };
        let norm_mins = if minutes < 0 {
            (minutes % 60) + 60
        } else {
            minutes % 60
        };
        let total_minutes = (norm_hrs * 60) + norm_mins;
        Clock {
            minutes: total_minutes,
        }
    }

    pub fn add_minutes(&self, minutes: i32) -> Self {
        let total_minutes = (self.minutes + minutes) % 60;
        let total_minutes = if total_minutes < 0 {
            total_minutes + 60
        } else {
            total_minutes
        };
        Clock {
            minutes: total_minutes,
        }
    }
}

impl Display for Clock {
    fn fmt(&self, f: &mut Formatter<'_>) -> Result {
        let hrs = (self.minutes / 60) % 24;
        let mins = self.minutes % 60;
        write!(f, "{:02}:{:02}", hrs, mins)
    }
}

impl cmp::PartialEq for Clock {
    fn eq(&self, other: &Self) -> bool {
        self.minutes == other.minutes
    }
}
