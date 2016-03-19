create table Characters (
  fname text, lname text, characterID integer primary key
);

create table Attributes (
  Intelligence int, Wits int, Resolve int,
  Strength int, Dexterity int, Stamina int,
  Presence int, Manipulation int, Composure int,
  AttributeID int,
  foreign key(AttributeID) references Characters(characterID)
);
create table Skills (
  Academics int,
  Computer int,
  Crafts int,
  Investigation int,
  Medicine int,
  Occult int,
  Politics int,
  Science int,

  Athletics int,
  Brawl int,
  Drive int,
  Firearms int,
  Larceny int,
  Stealth int,
  Survival int,
  Weaponry int,

  AnimalKen int,
  Empathy int,
  Expression int,
  Intimidation int,
  Persuasion int,
  Socialize int,
  Streetwise int,
  Subterfuge int,
  SkillID int,
  foreign key(SkillID) references Characters(characterID)
);
