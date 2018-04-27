using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Telecom.Models
{
    public class ChangeRequest
    {
        
        private int id;
        private Request oldRequest;
        private Request newRequest;
        private DateTime changeDate;

        public ChangeRequest()
        {
        }

        public ChangeRequest(Request oldRequest, Request newRequest, DateTime changeDate)
        {
            this.oldRequest = oldRequest;
            this.newRequest = newRequest;
            this.changeDate = changeDate;
        }

        public int Id { get => id; set => id = value; }
        public Request OldRequest { get => oldRequest; set => oldRequest = value; }
        public Request NewRequest { get => newRequest; set => newRequest = value; }
        public DateTime ChangeDate { get => changeDate; set => changeDate = value; }
    }
}