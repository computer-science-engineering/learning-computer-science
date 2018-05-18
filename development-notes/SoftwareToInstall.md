# A list of software to install

## 1. Compulsory

### 1.1 Any OS

- Java SDK
  - Ubuntu
    ```text
    sudo apt-get update
    sudo apt-get install default-jdk
    ```

- Git
  - Ubuntu
    ```text
    sudo apt-get install git
    ```
- kdiff3
- Python
  - Ubuntu
    ```text
    sudo apt-get python3.6

    // This does not seem to work
    python -m pip install --upgrade pip
    // So we use this
    sudo apt-install python-pip

    pip install --user numpy scipy matplotlib ipython jupyter pandas sympy nose
    // Consider adding this at the end of your ~/.bashrc file
    export PATH="$PATH:/home/your_user/.local/bin"
    ```
    [Reference](https://scipy.org/install.html)

- nodejs
  - Ubuntu
    ```text
    curl -sL https://deb.nodesource.com/setup_7.x | sudo -E bash -
    sudo apt-get install -y nodejs
    sudo apt-get install -y build-essential
    ```

- Sublime Text
  - Ubuntu [ref](https://www.sublimetext.com/docs/3/linux_repositories.html)
    ```text
    wget -qO - https://download.sublimetext.com/sublimehq-pub.gpg | sudo apt-key add -
    sudo apt-get install apt-transport-https
    echo "deb https://download.sublimetext.com/ apt/stable" | sudo tee /etc/apt/sources.list.d/sublime-text.list
    sudo apt-get update
    sudo apt-get install sublime-text
    ```

- R
  - Ubuntu
    ```text
    sudo apt-key adv --keyserver keyserver.ubuntu.com --recv-keys E084DAB9
    deb http://cran.r-project.org/bin/linux/ubuntu zesty/
    sudo apt-get update 
    sudo apt-get install r-base 
    sudo apt-get install r-base-dev 
    ```

- R Studio
  - Ubuntu
    ```text
    sudo apt --fix-broken install
    sudo apt-get install libjpeg62
    wget http://ftp.ca.debian.org/debian/pool/main/g/gstreamer0.10/libgstreamer0.10-0_0.10.36-1.5_amd64.deb
    wget http://ftp.ca.debian.org/debian/pool/main/g/gst-plugins-base0.10/libgstreamer-plugins-base0.10-0_0.10.36-2_amd64.deb
    ```
    *Now install with dpkg*
    ```text
    sudo dpkg -i libgstreamer0.10-0_0.10.36-1.5_amd64.deb
    sudo dpkg -i libgstreamer-plugins-base0.10-0_0.10.36-2_amd64.deb
    ```
    *We’ve purposefully installed old packages and don’t want Ubuntu’s package manager to enthusiastically upgrade them next time we update. To resolve that problem will put a hold on them with apt-mark:*
    ```text
    sudo apt-mark hold libgstreamer-plugins-base0.10-0
    sudo apt-mark hold libgstreamer0.10
    sudo apt-mark showhold
    sudo dpkg -i rstudio-***-amd64.deb
    ```
    *[Reference](https://mikewilliamson.wordpress.com/2016/11/14/installing-r-studio-on-ubuntu-16-10/)*

- Latex (MikTex on Windows)
  - Ubuntu
    ```text
    sudo apt-get install texlive-full
    ```
    *After you installed texlive-full you can list all the installed language packs with dpkg -l texlive-lang-\*. Then you can remove the unneeded ones with sudo apt-get purge -y texlive-lang-... (where ... is the language). 
    [Reference](https://tex.stackexchange.com/questions/372130/how-to-install-a-more-minimal-but-complete-texlive-on-ubuntu#comment919440_372130)*

- TexStudio
  - Ubuntu

    *May have to install libqt5scripts*

    ```text
    sudo dpkg -i texstudio_*_amd64.deb
    sudo apt --fix-broken install
    ```
- Android SDK
- Android Studio
  - Ubuntu
    ```text
    sudo apt-get install libc6:i386 libncurses5:i386 libstdc++6:i386 lib32z1 libbz2-1.0:i386
    sudo apt-get install unzip
    sudo unzip <filename.zip> -d /opt/
    ```
    *Navigate to the android-studio/bin/ directory, and execute studio.sh.
    To make Android Studio available in your list of applications, select Tools > Create Desktop Entry from the Android Studio menu bar.*

- Docker
  - Ubuntu

    *Set up the repository: Set up the Docker CE repository on Ubuntu. The lsb_release -cs sub-command prints the name of your Ubuntu version, like xenial or trusty.*
    ```text
    sudo apt-get -y install \
      apt-transport-https \
      ca-certificates \
      curl
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
    sudo add-apt-repository \
           "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
           $(lsb_release -cs) \
           stable"
    sudo apt-get update
    ```
    *Get Docker CE: Install the latest version of Docker CE on Ubuntu.*
    ```text
    sudo apt-get -y install docker-ce
    ```
    *Test your Docker CE installation: Test your installation.*
    ```text
    sudo docker run hello-world
    ```
    [Reference1](https://store.docker.com/editions/community/docker-ce-server-ubuntu?tab=description), [Reference2](https://askubuntu.com/questions/909691/how-to-install-docker-on-ubuntu-17-04)

- DotNet Core
- Visual Studio Code editor
- gradle
  - Ubuntu
    ```text
    sdk install gradle 4.2.1
    ```
  - Windows
    ```text
    gradle.org/install/
    ```
- MySQL Workbench
- FileZilla
- Vivaldi Browser
- Pandoc
- Audacity
- Libre Office
- DB Browser for SQLite
- GIMP
- Inkscape
- VLC Media player
- Evolus Pencil
- Opera Browser (for free VPN)
- KeePass Password Safe
  - Ubuntu

    *If you want an older version of KeePass 2.x*
    ```text
    sudo apt-get update
    sudo apt-get install keepass2
    ```
    *If you want the most recent verion of KeePass 2.x*
     ```text
     sudo apt-add-repository ppa:jtaylor/keepass
     sudo apt-get update
     sudo apt-get install keepass2
     ```
     *If you want something compatible with KeePass 1.x but is not actually KeePass*
     ```text
     sudo apt-get update
     sudo apt-get install keepassx
     ```
     [Reference](https://sourceforge.net/p/keepass/discussion/329220/thread/17d1bd26/#4a47/2783)

### 1.2 Windows only

- 7zip
- Microsoft OneDrive
- Visual Studio Community Edition
- WinPython (includes Spyder)
- ILSpy
- SysinternalsSuite
- GitExtensions
- Atlassian SourceTree
- Windows Media Player classic
- Adobe Lightroom
- Putty
- Tor browser
- Lame For Audacity
- Not Another Pdf Scanner 2
- Paint.NET
- Scrivener
- Popc*** T***
- qBittorrent
- QTTabBar
- ZoneAlarm Free Firewall
- SumatraPdf
- XnViewMP
- NitroPdf
- DisplayFusion
- Calibre
- FreeCommander XE
- BurnAware Free
- Gom Audio
- Google\Nik Collection
- Recuva
- Speccy
- ProcessHacker
- Wox
- Greenshot
- Winscp
- CDisplayEx
- f.lux

### 1.3 Linux only

- GitKraken
- conky
- redshift
    ```text
    sudo apt install redshift
    sudo apt install redshift-gtk
    ```
- Meld
- Spyder
- sdkman 
    ```text
    http://sdkman.io/install.html    
    ```

- gdebi
  - Ubuntu

    `sudo apt install gdebi`
- snapd
  - Ubuntu

    `sudo apt install snapd` or `sudo snap install`
- rclone (for Microsoft OneDrive)
  - Ubuntu

      *Fetch and unpack*
      ```text
      curl -O https://downloads.rclone.org/rclone-current-linux-amd64.zip
      unzip rclone-current-linux-amd64.zip
      cd rclone-*-linux-amd64
      ```
      *Copy binary file*
      ```text
      sudo cp rclone /usr/bin/
      sudo chown root:root /usr/bin/rclone
      sudo chmod 755 /usr/bin/rclone
      ```
      *Install manpage*
      ```text
      sudo mkdir -p /usr/local/share/man/man1
      sudo cp rclone.1 /usr/local/share/man/man1/
      sudo mandb
      ```
      *Run `rclone config` to setup. See [rclone config docs](https://rclone.org/docs/) for more details.*
      *For setting up Microsoft OneDrive - steps [here](https://rclone.org/onedrive/).*
      [Reference](https://rclone.org/install/)

      *You could also install rclone using snapd:* `sudo snap install rclone --classic`

## 2. Optional

### 2.1 Any OS

- Qt SDK
- Scala
- Ruby
- Bitnami Wordpress stack installer
- Aptana plugin for Eclipse Java IDE
- Go lang
- Dart lang
- Scilab 
- [GNU Octave](https://www.gnu.org/software/octave/)
- [SageMath](http://www.sagemath.org)
- [Junolab for Julia](http://junolab.org)
- Blender
- Pencil animation
- Synfig Studio
- Krita
- Scribus 
- plume-creator
- Ren'Py
- Freemind
- VirtualBox
- Atom code editor
- Brackets code editor
- Haroopad
- Bleachbit
- RedNotebook
- Openshot video editor
  - Ubuntu
    ```text
    sudo add-apt-repository ppa:openshot.developers/ppa
    sudo apt-get update
    sudo apt-get install openshot-qt
    ```
- IntelliJ IDEA Community Edition
  - Ubuntu
    ```text
    sudo tar xf <ideaIC or ideaIU>-*.tar.gz -C /opt/
    cd opt/<ideaIC or ideaIU>-*/bin
    ./idea.sh
    ```
  Plugins: CheckStyle, Findbugs
- Jetbrains PyCharm IDE Community Edition
- [Vectr](https://vectr.com)
- Lua
  - Windows

    [Installing Lua on a Windows system](http://www.thijsschreijer.nl/blog/?p=863)

### 2.2 Windows only

- Microsoft Threat Modeling Tool
- Autodesk Pixlr
- FotoSketcher
- Itranslator 2003 Beta
- Mp3tag
- PdfEscape
- Freac Audio Converter
- EaseUS Partition Master
- Search and Replace
- yWriter6
- Manuskript
- Notepad++
- ImageGlass
- Adobe Photoshop
- Nodepad3
- Hyper.is
- cmder
- Eclipse Installer
- Eclipse Java IDE (Latest Released and Latest)
  - PyDev

### 2.3 Linux only

- 7zip
- [Stacer](https://github.com/oguzhaninan/Stacer)
- [Sublime Text](http://www.omgubuntu.co.uk/2017/05/how-to-install-sublime-text-ubuntu-linux)

## Linux related

### Enabling right mouse click option for a Synaptics mousepad

1. Open a terminal by pressing Ctrl+Alt+T and use the following command: `sudo nautilus`. This will open a window with sudo privileges and allow you to change and save root files.
1. Find and open the file: /usr/share/X11/xorg.conf.d/70-synaptics.conf
1. Locate the paragraph:
    ```text
    # This option enables the bottom right corner to be a right button on clickpads
    # and the right and middle top areas to be right / middle buttons on clickpads
    # with a top button area.
    # This option is only interpreted by clickpads.
      Section "InputClass"
          Identifier "Default clickpad buttons"
          MatchDriver "synaptics"
          Option "SoftButtonAreas" "50% 0 82% 0 0 0 0 0"
          Option "SecondarySoftButtonAreas" "58% 0 0 15% 42% 58% 0 15%"
        EndSection
    ```
1. Add two extra lines before `Option "SoftButtonAreas" "50% 0 82% 0 0 0 0 0"` :
    ```text
    Option "ClickPad"         "true"
    Option "EmulateMidButtonTime" "0"
    ```
   (first one enables right click and the second middle click)

1. Now save the changes and Log out/Log in. The right click should be working now!

[Reference](https://askubuntu.com/questions/579645/right-click-on-synaptic-touchpad-not-working-on-ubuntu-14-10)

On Wayland desktop enviroment:
https://ask.fedoraproject.org/en/question/100632/touchpad-libinput-to-xorg-configuration-not-working/
http://www.ubuntuvibes.com/2017/04/how-to-configure-touchpad-in-ubuntu.html
https://bbs.archlinux.org/viewtopic.php?id=222883
https://www.topbug.net/blog/2017/02/23/enable-natural-scrolling-for-trackpads-using-libinput/
https://superuser.com/questions/1252871/migrate-from-x11-to-wayland-multitouch-on-fedora-25?newreg=0570eaa16b904c98a5d82a677c449d4e

### Configuring GetDeb

Install the getdeb package.
Or configure the repository manually:
Go to System-Administration-Software Sources, Third-Party Software tab, Add:

```text
deb http://archive.getdeb.net/ubuntu zesty-getdeb apps
```

Add the repository GPG key, open a terminal window and type:

```text
wget -q -O- http://archive.getdeb.net/getdeb-archive.key | sudo apt-key add -
```

If the application cannot be found, run this command and try again: `sudo apt-get update`.
If you want to uninstall the GetDeb repository run this command: `sudo apt-get remove getdeb-repository`.

[Reference](http://www.getdeb.net/updates/Ubuntu/17.04#how_to_install)

### Make battery last longer

TLP is Linux management power application, this application controls CPU temperature and this contributes to better control of battery life in long run. 

For installation and launching run: `sudo apt install tlp tlp-rdw && sudo tlp start`

[Reference]http://www.linuxandubuntu.com/home/15-things-to-do-after-installing-ubuntu-1704-zesty-zapus

### Installing gnome on top of Ubuntu

```text
sudo apt-get install ubuntu-gnome-desktop
```

*Then choose gdm3 or lightdm. Recommend to reboot.
If you need to change the login manager later on you can do that with `dpkg-reconfigure gdm3` or `dpkg-reconfigure lightdm` respectively.*

[Reference](https://askubuntu.com/questions/766071/install-gnome-shell-on-ubuntu-16-04?noredirect=1&lq=1)

### Removing Unity

```text
sudo apt purge unity8 ubuntu-system-settings && sudo apt autoremove
```

### Stuck at login manager

[Reference](https://unix.stackexchange.com/questions/170650/ubuntu-does-no-let-me-log-in-to-my-user-how-can-i-fix-it)
