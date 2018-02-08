# Adoptation

TODO: Edit this intro

## Initial Setup

I added these quick setup instructions just incase some of you aren't super familiar with Git/GitHub or you run into any problems along the way.

### Cloning the Repo

I would first create a folder to hold your *Eclipse* workspace (I called mine *"Adoptation Workspace"*), then inside that folder create another one called *Adoptation*. Either using Terminal or Git Bash, go inside both those folders and run:

```
git init
```
and then:

```
git remote add origin https://github.com/McFeelio/Adoptation/
```
and also:

```
git pull origin master
```

You might have to enter your GitHub username/password somewhere inbetween those steps, depending on your setup. Once that's all done, you should have everything you need to import the project to Eclipse.

### Setting up Eclipse

Fire up Eclipse, and when the *workspace selector* pops up, navigate to that **first** folder you created earlier (the one I called *Adoptation Workspace*). Click launch.

Then all you have to do is import the project. Just go to *File -> Import -> General -> Existing project into Workspace*. Where it asks for the destination, just browse to that second folder (the one I called *Adoptation*) and click okay. The whole project should then be shown on the left, and you won't have to do any of this shit again. 
