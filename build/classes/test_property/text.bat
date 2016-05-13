@ECHO OFF
echo this is a test.bat file ,if the system time is before midi, the exit_code will be 01,else it will be 02.
rem for /F "tokens=2" %%i in ('date /t') do set mydate = %%i
rem set mytime=%time%

for /F "usebackq tokens=1,2 delims==" %%i in (`wmic os get LocalDateTime /VALUE 2^>NUL`) do if '.%%i.'=='.LocalDateTime.' set ldt=%%j
set ldt=%ldt:~0,4%-%ldt:~4,2%-%ldt:~6,2% %ldt:~8,2%:%ldt:~10,2%:%ldt:~12,6%
echo Local date is [%ldt%]

For /f "tokens=1-2 delims=/:" %%a in ('time /t') do (set mytime=%%a%%b)
IF %mytime% LSS (1200)
exit 01

IF %mytime% GTR (1200)
exit 02

echo my time is %mytime%

::set the errorlevel manually, if we add this sentence
