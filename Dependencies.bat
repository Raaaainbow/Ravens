@echo off

:: Install Github
winget install --id Git.Git -e --source winget

@echo off

:: Specify the GitHub repository URL
set REPO_URL=https://github.com/Raaaainbow/Ravens

:: Specify the directory to download the repository into (e.g., Downloads folder)
set TARGET_DIR=%USERPROFILE%\Downloads

:: Navigate to the target directory
cd /d %TARGET_DIR%

:: Clone the repository
git clone %REPO_URL%

pause