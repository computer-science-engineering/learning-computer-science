1. http://nvie.com/posts/a-successful-git-branching-model/ 
1. https://jacovanstaden.files.wordpress.com/2011/03/git-flow-overview.jpg 
1. https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet 
1. Implement GitFlow. 
1. Set default branch in GitHub to be develop.


http://www.git-scm.com/download/win (Must)
https://desktop.github.com/ (optional; but needed to get around VS 2015 Git plugin bug)
https://www.sourcetreeapp.com/ (Optional; instead of GitHub for desktop)
 
 
Workflow if you are forking from another repo:
 
https://help.github.com/articles/configuring-a-remote-for-a-fork/
https://help.github.com/articles/syncing-a-fork/
https://help.github.com/articles/pushing-to-a-remote/
 
Fork original repo in Github into your account
Clone repo into your local disk (can be done using VS)

 
`mtalukdar@gamma MINGW64 /d/devgithub/qi-samples (master)`
`$ git remote -v`
`origin  https://github.com/manastalukdar/Qi-Samples.git (fetch)`
`origin  https://github.com/manastalukdar/Qi-Samples.git (push)`
 
(Step below not needed if you cloned GitHub repo using GitHub for desktop)
`mtalukdar@gamma MINGW64 /d/devgithub/qi-samples (master)`
`$ git remote add upstream https://github.com/osisoft/Qi-Samples.git`
 
`mtalukdar@gamma MINGW64 /d/devgithub/qi-samples (master)`
`$ git remote -v`
`origin  https://github.com/manastalukdar/Qi-Samples.git (fetch)`
`origin  https://github.com/manastalukdar/Qi-Samples.git (push)`
`upstream        https://github.com/osisoft/Qi-Samples.git (fetch)`
`upstream        https://github.com/osisoft/Qi-Samples.git (push)`
 
`mtalukdar@gamma MINGW64 /d/devgithub/qi-samples (master)`
`$ git fetch upstream`
`remote: Counting objects: 154, done.`
`remote: Total 154 (delta 41), reused 41 (delta 41), pack-reused 113`
`Receiving objects: 100% (154/154), 1.68 MiB | 1.88 MiB/s, done.`
`Resolving deltas: 100% (76/76), completed with 24 local objects.`
`From https://github.com/osisoft/Qi-Samples`
`* [new branch]      Moving-samples-out-of-docs -> upstream/Moving-samples-out-of-docs`
`* [new branch]      master     -> upstream/master`
 
`mtalukdar@gamma MINGW64 /d/devgithub/qi-samples (master)`
`$ git checkout master`
`Already on 'master'`
`Your branch is up-to-date with 'origin/master'.`
 
`mtalukdar@gamma MINGW64 /d/devgithub/qi-samples (master)`
`$ git merge upstream/master`
`Updating a4dbe11..ebb3f5c`
`…`
`…`
`…`
 
`mtalukdar@gamma MINGW64 /d/devgithub/qi-samples (master)`
`$ git push origin master`
`Counting objects: 154, done.`
`Delta compression using up to 24 threads.`
`Compressing objects: 100% (75/75), done.`
`Writing objects: 100% (154/154), 1.69 MiB | 667.00 KiB/s, done.`
`Total 154 (delta 69), reused 144 (delta 66)`
`To https://github.com/manastalukdar/Qi-Samples.git`
   `a4dbe11..ebb3f5c  master -> master`
 
 
Once changes made, commit and the push (if there are new changes in forked repo that haven’t been pulled yet, you have to pull first before pushing).
 
Workflow if you are working off of your own repo:
 
Clone repo from GitHub into your local machine either using GitGui, GitHub for desktop (recommended), Git bash, or VS 2015 plugin (has a bug where it does not pick up recently forked/created repos).
Make changes.
Stage changes (add, rm, etc.) – recommended to use GitGui – Not needed if using VS plugin
Commit
Push changes
