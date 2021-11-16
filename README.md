# Productivize
Task and productivity Management Application in java

## Github commands to contribute for collaborators

#### Step 1 : Clone the project

Open your Gitbash and enter `git clone https://github.com/ShrutiJ-01/productivize.git`

This creates a clones the repo into your local machine.
#### Step 2: Check remotes

Enter `git remote -v` to get a list of remotes for your repository.

It should list the following remotes:
```
origin  https://github.com/ShrutiJ-01/productivize.git (fetch)
origin  https://github.com/ShrutiJ-01/productivize.git (push)
```
### Step 3 : Making Changes and Commiting them

After you are done making changes to the code, use the following git commands to check,stage and commit files.

Use these Git commands in sequence:
```
git status
git add .
git commit -m "describe your changes in few words"
```

#### Step 4 : Push the changes 

After you've commited changes, execute the follwing commands

1) Pull any changes from remote

`git pull origin main`

2) Push your changes to remote

`git push origin main`

This merges any recent changes from the remote, and then pushes the changes you made to the remote repo.

