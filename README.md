# Productivize
Task and productivity Management Application in java

## Github commands to contribute (for collaborators)

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
#### Step 3: Create a new Branch

Enter `git checkout -b branchname` to get create a new branch and switch to it.

#### Step 4 : Making Changes and Commiting them

After you are done making changes to the code, use the following git commands to check,stage and commit files.

Use these Git commands in sequence:
```
git status
git add .
git commit -m "describe your changes in few words"
```
>Note : The `git add .` stages all files. You might accidently stage and commit files unintended files this way. Use `git add filename.extension` to stage files individually when necessary.

#### Step 5 : Push the changes 

After you've commited changes, execute the follwing commands

1) Pull any changes from remote

`git pull origin main`

2) Push your changes to remote

`git push origin branchname`

These commands merges any recent changes from the main branch, and then pushes the changes you made to the remote repo.
